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


import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.Nullable;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import com.yookue.mavenplugin.javadocdocent.constant.ResourceBundleConst;


/**
 * Utilities for {@link java.util.ResourceBundle}
 *
 * @author David Hsing
 * @see java.util.ResourceBundle
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue"})
public abstract class ResourceBundleUtils {
    /**
     * Returns the message from taglet/Messages properties file
     *
     * @return the title from taglet/Messages properties file
     */
    @Nullable
    public static String getTagletMessage(@Nullable Locale locale, @Nullable String key, @Nullable String defaults) {
        if (locale == null || StringUtils.isBlank(key)) {
            return null;
        }
        List<Locale> lookups = LocaleUtils.localeLookupList(locale);
        for (Locale lookup : lookups) {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle(ResourceBundleConst.TAGLET_MESSAGE, lookup);
                String result = bundle.getString(key);
                if (StringUtils.isNotEmpty(result)) {
                    return result;
                }
            } catch (Exception ignored) {
            }
        }
        return defaults;
    }
}
