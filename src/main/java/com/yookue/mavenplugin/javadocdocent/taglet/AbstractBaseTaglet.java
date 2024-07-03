/*
 * Copyright (c) 2024 Yookue Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yookue.mavenplugin.javadocdocent.taglet;


import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.StandardDoclet;
import jdk.javadoc.doclet.Taglet;
import java.util.Locale;
import java.util.Set;
import jakarta.annotation.Nonnull;
import lombok.Getter;


/**
 * An abstract taglet that representing tags
 *
 * @author David Hsing
 * @reference "https://openjdk.java.net/groups/compiler/using-new-doclet.html"
 * @reference "https://github.com/jamesdbaker/javadoc9/"
 * @reference "https://riptutorial.com/maven/example/30104/reading-a-pom-xml-at-runtime-using-maven-model-plugin"
 */
@Getter
@SuppressWarnings({"JavadocDeclaration", "JavadocLinkAsPlainText"})
public abstract class AbstractBaseTaglet implements Taglet {
    private Locale locale;

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Location> getAllowedLocations() {
        return Set.of(Taglet.Location.OVERVIEW, Taglet.Location.MODULE, Taglet.Location.PACKAGE, Taglet.Location.TYPE, Taglet.Location.CONSTRUCTOR, Taglet.Location.METHOD, Taglet.Location.FIELD);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(@Nonnull DocletEnvironment env, @Nonnull Doclet doclet) {
        locale = (doclet instanceof StandardDoclet standard) ? standard.getLocale() : null;
    }
}
