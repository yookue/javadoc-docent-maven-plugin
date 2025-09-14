# Javadoc Docent Maven Plugin

javadoc-docent-maven-plugin is a maven plugin, to support generating alternative javadoc annotations, with multilingual capability.

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
                            <tagletClass>cn.unikue.mavenplugin.javadocdocent.taglet.AttentionTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>cn.unikue.mavenplugin.javadocdocent.taglet.DtddTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>cn.unikue.mavenplugin.javadocdocent.taglet.ReferenceTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>cn.unikue.mavenplugin.javadocdocent.taglet.TaskTagletcn.unikue.mavenplugin.javadocdocent.taglet.TaskTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>cn.unikue.mavenplugin.javadocdocent.taglet.UrlTaglet</tagletClass>
                        </taglet>
                        <taglet>
                            <tagletClass>cn.unikue.mavenplugin.javadocdocent.taglet.WarningTaglet</tagletClass>
                        </taglet>
                    </taglets>
                    <tagletArtifact>
                        <groupId>cn.unikue.mavenplugin</groupId>
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
|------------|-------------|-------------------------------|
| @attention | block       | @attention "content"          |
| @dtdd      | inline      | {@dtdd "title" "content"}     |
| @reference | block       | @reference "href" ["content"] |
| @task      | block       | @task "content"               |
| @url       | inline      | {&#64;url "href" ["content"]} |
| @warning   | block       | @warning "content"            |

## Document

- Github: https://github.com/unikueltd/javadoc-docent-maven-plugin

## Requirement

- jdk 17+

## License

This project is under the [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)

See the `NOTICE.txt` file for required notices and attributions.

## Donation

You like this package? Then [donate to Unikue](https://unikue.cn/donation) to support the development.

## Website

- Unikue: https://unikue.cn
