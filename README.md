[![Main branch build status](https://github.com/grace-plugins/grace-policy/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-plugins/grace-policy/actions?query=workflow%3A%Grace+CI%22)
[![Apache 2.0 license](https://img.shields.io/badge/License-APACHE%202.0-green.svg?logo=APACHE&style=flat)](https://opensource.org/licenses/Apache-2.0)
[![Latest version on Maven Central](https://img.shields.io/maven-central/v/org.graceframework.plugins/policy.svg?label=Maven%20Central&logo=apache-maven&style=flat)](https://search.maven.org/search?q=g:org.graceframework.plugins)
[![Grace on X](https://img.shields.io/twitter/follow/graceframework?style=social)](https://twitter.com/graceframework)

# Grace Policy

Authorization plugin for Grails/Grace applications.


## Usage

Add dependency to the `build.gradle`,

```gradle

repositories {
    mavenCentral()
}

dependencies {
    implementation "org.graceframework.plugins:policy:VERSION"
}
```


### Creating a Policy

In `app/controllers`,

```groovy
class PostController {

    def show(Long id) {
        def post = postService.get(id)
        authorize post
        // some
    }

}
```

In `app/policies`, create a `Policy` for `PostController`,

```groovy
class PostPolicy {

    def show() {
        record.status == 'PUBLISHED' || record.author.id == user.id || user.hasRole('ROLE_ADMIN')
    }

}
```

`policy` plugin provides `authorize(record, options)` for your `Controllers`,

```groovy
// Without record (null)
authorize() 

// With post, use PostPolicy, actionName is the rule
authorize(post)

// Use custom Policy and rule
authorize(post, [with: NewPostPolicy, to: 'manage'])
```

## Development

### Build from source

```
git clone https://github.com/grace-plugins/grace-policy.git
cd grace-policy
./gradlew publishToMavenLocal
```

## Support Version

* Grace 2022.0.0+
* Grails 3.0+

## Roadmap

* Spring Security integration
* Support Grails Service

## License

This plugin is available as open source under the terms of the [APACHE LICENSE, VERSION 2.0](http://apache.org/Licenses/LICENSE-2.0)

## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Plugins](https://github.com/grace-plugins)
- [Grace Policy Plugin](https://github.com/grace-plugins/grace-policy)
