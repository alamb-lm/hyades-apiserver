/*
 * This file is part of Dependency-Track.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) OWASP Foundation. All Rights Reserved.
 */
package org.dependencytrack.tasks;

import alpine.common.logging.Logger;
import alpine.event.framework.Event;
import alpine.event.framework.LoggableSubscriber;
import alpine.model.ConfigProperty;
import alpine.model.OidcUser;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONValue;

import org.dependencytrack.event.GitLabSyncEvent;
import org.dependencytrack.integrations.gitlab.GitLabClient;
import org.dependencytrack.integrations.gitlab.GitLabSyncer;
import org.dependencytrack.persistence.QueryManager;

import static org.dependencytrack.model.ConfigPropertyConstants.GITLAB_ENABLED;
import static org.dependencytrack.model.ConfigPropertyConstants.GITLAB_INCLUDE_ARCHIVED;
import static org.dependencytrack.model.ConfigPropertyConstants.GITLAB_TOPICS;

import java.util.List;

public class GitLabSyncTask implements LoggableSubscriber {

    private static final Logger LOGGER = Logger.getLogger(GitLabSyncTask.class);
    private final boolean isEnabled;

    public GitLabSyncTask() {
        final String groupName = GITLAB_ENABLED.getGroupName();

        try (final QueryManager qm = new QueryManager()) {
            final ConfigProperty enabled = qm.getConfigProperty(groupName, GITLAB_ENABLED.getPropertyName());

            this.isEnabled = enabled != null && Boolean.parseBoolean(enabled.getPropertyValue());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void inform(final Event event) {
        if (!(event instanceof GitLabSyncEvent && this.isEnabled)) {
            return;
        }

        GitLabSyncEvent gitLabSyncEvent = (GitLabSyncEvent) event;

        String accessToken = gitLabSyncEvent.getAccessToken();
        if (accessToken == null || accessToken.isEmpty()) {
            LOGGER.warn("GitLab syncing is enabled, but no access token was provided. Skipping.");
            return;
        }

        LOGGER.info("Starting GitLab sync task");

        try (QueryManager qm = new QueryManager()) {
            final OidcUser user = qm.getUser(gitLabSyncEvent.getUser().getUsername(), OidcUser.class);
            if (user == null) {
                LOGGER.warn("GitLab syncing is enabled, but no authenticated user was provided. Skipping.");
                return;
            }

            String topicsProperty = qm.getConfigProperty(
                    GITLAB_TOPICS.getGroupName(), GITLAB_TOPICS.getPropertyName()).getPropertyValue();
            List<String> topics = List.of(JSONValue.parse(topicsProperty, JSONArray.class).toArray(String[]::new));

            String includeArchivedString = qm.getConfigProperty(
                    GITLAB_INCLUDE_ARCHIVED.getGroupName(), GITLAB_INCLUDE_ARCHIVED.getPropertyName())
                    .getPropertyValue();
            boolean includeArchived = Boolean.parseBoolean(includeArchivedString);

            GitLabClient gitLabClient = new GitLabClient(accessToken, topics, includeArchived);
            GitLabSyncer syncer = new GitLabSyncer(user, gitLabClient);
            syncer.setQueryManager(qm);
            syncer.synchronize();
        }

        LOGGER.info("GitLab sync complete");
    }

}
