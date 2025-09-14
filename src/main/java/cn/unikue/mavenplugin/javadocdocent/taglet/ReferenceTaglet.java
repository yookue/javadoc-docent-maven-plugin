/*
 * Copyright (c) 2023 Unikue Ltd. All rights reserved.
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

package cn.unikue.mavenplugin.javadocdocent.taglet;


import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Element;
import jakarta.annotation.Nonnull;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.UnknownBlockTagTree;
import cn.unikue.mavenplugin.javadocdocent.util.JavadocContentUtils;
import cn.unikue.mavenplugin.javadocdocent.util.ResourceBundleUtils;


/**
 * A block taglet that representing {@code @reference} tag
 *
 * <pre><code>
 *     &#64;reference "href" ["content"]
 * </code></pre>
 * represents
 * <pre><code>
 *     &lt;dt&gt;
 *         &lt;span class="simpleTagLabel&gt;Reference:&lt;/span&gt;
 *     &lt;/dt&gt;
 *     &lt;dd&gt;
 *         &lt;table border="0" cellpadding="2" cellspacing="0"&gt;
 *             &lt;tr&gt;&lt;td&gt;&lt;a href="href" target="_blank"&gt;content&lt;/a&gt;&lt;/td&gt;&lt;/tr&gt;
 *         &lt;/table&gt;
 *     &lt;/dd&gt;
 * </code></pre>
 *
 * @author David Hsing
 * @reference "https://github.com/Broele/ReferenceTaglet/"
 */
@SuppressWarnings({"unused", "BooleanMethodIsAlwaysInverted", "UnusedReturnValue", "JavadocDeclaration", "JavadocLinkAsPlainText"})
public class ReferenceTaglet extends AbstractBlockTaglet {
    private static final String TAG_NAME = "reference";    // $NON-NLS-1$
    private static final String TAG_TITLE = "Reference:";    // $NON-NLS-1$

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return TAG_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("DuplicatedCode")
    public String toString(@Nonnull List<? extends DocTree> tags, @Nonnull Element element) {
        if (tags.isEmpty()) {
            return null;
        }
        List<String> tbody = new ArrayList<>();
        for (DocTree tag : tags) {
            if (!(tag instanceof UnknownBlockTagTree tree)) {
                continue;
            }
            String[] args = StringUtils.split(tree.getContent().toString(), StringUtils.SPACE);
            String href = JavadocContentUtils.unquote(ArrayUtils.get(args, 0));
            String content = JavadocContentUtils.unquote(ArrayUtils.get(args, 1));
            String tr = JavadocContentUtils.trTdAOpeningBlank(href, content);
            if (StringUtils.isNotBlank(tr)) {
                tbody.add(tr);
            }
        }
        if (tbody.isEmpty()) {
            return null;
        }
        String dtTitle = ResourceBundleUtils.getTagletMessage(super.getLocale(), "Taglet.reference", TAG_TITLE);    // $NON-NLS-1$
        return JavadocContentUtils.dtSpanDdTable(dtTitle, StringUtils.join(tbody, StringUtils.EMPTY));
    }
}
