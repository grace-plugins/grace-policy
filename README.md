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

### Basic Usage

The core component of this plugin is a policy class. `Policy` class describes how you control access to resources.

We suggest having a separate policy class for each resource and encourage you to follow these conventions:

* put `policies` into the `app/policies` folder;
* name policies using the corresponding singular resource name (domain name) with a `Policy` suffix, e.g. `Post -> PostPolicy`;
* name rules using a predicate form of the corresponding activity (typically, a controller's action), e.g. `PostsController#update -> PostPolicy#update`.

### Writing Policies

`Policy` class contains predicate methods (rules) which are used to authorize activities.

A Policy is instantiated with the target record (authorization object) and the authorization context (by default equals to `user`):

```groovy
class PostPolicy {

    def update() {
        record?.author?.id == user?.id || user?.isAdmin()
    }

}
```

### Using with Controllers

In most cases, you do not have to do anything except writing policy files and adding `authorize` calls.

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
