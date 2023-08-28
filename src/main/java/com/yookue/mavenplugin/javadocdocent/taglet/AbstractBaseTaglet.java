/*
 * Copyright (c) 2021 Yookue Ltd. All rights reserved.
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


import javax.annotation.Nullable;
import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;


/**
 * An abstract taglet that representing tags
 *
 * @author David Hsing
 * @reference "https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/index.html"
 * @reference "https://docs.oracle.com/javase/8/docs/technotes/guides/javadoc/taglet/overview.html"
 * @reference "https://docs.oracle.com/javase/8/docs/jdk/api/javadoc/taglet/com/sun/tools/doclets/Taglet.html"
 */
@SuppressWarnings({"unused", "JavadocDeclaration", "JavadocLinkAsPlainText"})
public abstract class AbstractBaseTaglet implements Taglet {
    /**
     * Returns true if this taglet is used in constructor documentation
     *
     * @return true if this taglet is used in constructor documentation
     */
    @Override
    public boolean inConstructor() {
        return true;
    }

    /**
     * Returns true if this taglet is used in field documentation
     *
     * @return true if this taglet is used in field documentation
     */
    @Override
    public boolean inField() {
        return true;
    }

    /**
     * Returns true if this taglet is used in method documentation
     *
     * @return true if this taglet is used in method documentation
     */
    @Override
    public boolean inMethod() {
        return true;
    }

    /**
     * Returns true if this taglet is used in overview documentation
     *
     * @return true if this taglet is used in overview documentation
     */
    @Override
    public boolean inOverview() {
        return true;
    }

    /**
     * Returns true if this taglet is used in package documentation
     *
     * @return true if this taglet is used in package documentation
     */
    @Override
    public boolean inPackage() {
        return true;
    }

    /**
     * Returns true if this taglet is used in type documentation
     *
     * @return true if this taglet is used in type documentation
     */
    @Override
    public boolean inType() {
        return true;
    }

    /**
     * Returns true if this taglet is an inline tag
     *
     * @return true if this taglet is an inline tag
     */
    @Override
    public abstract boolean isInlineTag();

    /**
     * Returns the name of this taglet
     *
     * @return the name of this taglet
     */
    @Override
    public abstract String getName();

    /**
     * Returns the string representation of the given {@link com.sun.javadoc.Tag}
     *
     * @param tag the {@link com.sun.javadoc.Tag} to be represented
     *
     * @return the string representation of the given {@link com.sun.javadoc.Tag}
     */
    @Override
    public abstract String toString(@Nullable Tag tag);

    /**
     * Returns the string representation of the given array of {@link com.sun.javadoc.Tag}
     *
     * @param tags the array of {@link com.sun.javadoc.Tag} to be represented
     *
     * @return the string representation of the given array of {@link com.sun.javadoc.Tag}
     */
    @Override
    public abstract String toString(@Nullable Tag[] tags);
}
