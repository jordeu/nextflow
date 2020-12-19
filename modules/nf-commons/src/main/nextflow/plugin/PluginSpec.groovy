/*
 * Copyright 2020, Seqera Labs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package nextflow.plugin

import groovy.transform.Canonical

/**
 * Model a plugin Id and version
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@Canonical
class PluginSpec {

    /**
     * Plugin unique ID
     */
    String id

    /**
     * The plugin version
     */
    String version

    /**
     * Parse a plugin fully-qualified ID eg. nf-amazon@1.2.0
     *
     * @param fqid The fully qualified plugin id
     * @return A {@link PluginSpec} representing the plugin
     */
    static PluginSpec parse(String fqid) {
        final tokens = fqid.tokenize('@')
        final id = tokens[0]
        return new PluginSpec(id, tokens[1])
    }
}