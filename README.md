# Javadoc Docent Maven Plugin
Yookue javadoc-docent-maven-plugin is a maven plugin, to support generating alternative javadoc annotations, multilingual is available.

## Quickstart

- Configure maven `pom.xml` under plugin `maven-javadoc-plugin`
```xml
<project>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>LATEST</version>
                <configuration>
                    <taglets>
                        <taglet>
                            <tagletClass>com.yookue.mavenplugin.javadocdocent.taglet.AttentionTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.yookue.mavenplugin.javadocdocent.taglet.DtddTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.yookue.mavenplugin.javadocdocent.taglet.ReferenceTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.yookue.mavenplugin.javadocdocent.taglet.TodoTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.yookue.mavenplugin.javadocdocent.taglet.UrlTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>com.yookue.mavenplugin.javadocdocent.taglet.WarningTaglet</tagletClass>
                        </taglet>
                    </taglets>
                    <tagletArtifact>
                        <groupId>com.yookue.mavenplugin</groupId>
                        <artifactId>javadoc-docent-maven-plugin</artifactId>
                        <version>LATEST</version>
                    </tagletArtifact>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

> You may just include the necessary `taglet` as you wish.

- Supported javadoc annotations are:

| Annotation | Taglet Type | Usage                         |
| ---------- | ----------- | ----------------------------- |
| @attention | block       | @attention "content"          |
| @dtdd      | inline      | {@dtdd "title" "content"}     |
| @reference | block       | @reference "href" ["content"] |
| @todo      | block       | @todo "content"               |
| @url       | inline      | {&#64;url "href" ["content"]} |
| @warning   | block       | @warning "content"            |

## Document

- javadoc-docent-maven-plugin github: https://github.com/yookue/javadoc-docent-maven-plugin
- javadoc-docent-maven-plugin javadoc: https://javadoc.wiki/public/apidoc/com.yookue.mavenplugin/javadoc-docent-maven-plugin/latest

## Requirement

- jdk 1.8+

## Contribution

We accept Pull Requests via GitHub. There are some guidelines which will make applying PRs easier for us:
- No tabs! Please use spaces for indentation.
- Respect the code style.
- Create minimal diffs - disable on save actions like reformat source code or organize imports. If you feel the source code should be reformatted, create a separate PR for this change.

## License

This code is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)
See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate back to Yookue](https://yookue.com/public/donate) to support the development.

## Website

- Yookue: https://yookue.com
