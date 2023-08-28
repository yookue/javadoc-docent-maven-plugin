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

package com.yookue.mavenplugin.javadocdocent.util;


import java.util.Locale;
import com.sun.tools.doclets.formats.html.HtmlDoclet;


/**
 * Utilities for {@link com.sun.javadoc.Doclet}
 *
 * @author David Hsing
 * @see com.sun.javadoc.Doclet
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public abstract class JavadocDocletUtils {
    private static final HtmlDoclet DOCLET_INSTANCE = new HtmlDoclet();

    public static Locale getHtmlDocletLocale() {
        return DOCLET_INSTANCE.configuration().getLocale();
    }
}
