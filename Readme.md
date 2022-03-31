# Home / Contas do Lar

This app is designed to help me on my home automation.

The first step is to help me controlling my expenses and bills.
Some details of this project will be shown here once the screens get implemented.

Other steps like irrigation automation will be developed in the future.

## Instructions to build
Due to some issues with experimental features, in order to compile this project you must first publish a dependency on mavenLocal()
- Clone this repository on branch js-ir (default): https://github.com/leandro-dev/firebase-kotlin-sdk
- run gradle task `publishMavenLocal()`

This is due to the fact that we need this library with `js(IR)` that is not available on release 1.4.3 (lastest at the time being).
And also due to another issue with kotlin-js + source dependency provided by gradle.
Check file `settings.gradle.kts` for further details.

## For developers

This project is designed to be multiplatform with kotlin.
The official Jetbrains libraries, such as kotlin, coroutines, datetime, will be accessible to all modules, like aspects.
Other unofficial libraries, such as Firebase-kotlin-sdk (dev.gitlive) will be encapsulated in order to abstract and help future refactors.

The only exception for the time being is for Dependency Injection library, because it is very hard to abstract. Different libraries such as Koin, Dagger, Kodein, have a very different syntax.
The reason for choosing Kodein is because it targets several platforms on kotlin multiplatform projects.

### Android
My main speciality is as Android Developer. I'm attempting to use only recent launched libraries and explore them.

App Layers:
- For View we are using Android Compose only.
- For ViewModel, we are using an adaptation in order to make it reusable for multiplatform.
- There is a business layer to manage some in-app rules.
- For DataSource we are using a NoSQL database with cached local storage and automatic background sync with remote storage (Firestore).

### Web
- It will be my first project with kotlin to web, so I still have to learn how to configure and make it run.

### iOS
- I really wanted to make this project to compile for iOS as well, but there is a big problem: I don't own a Mac.
- I've attempted to use Bitrise in order to generate iOS builds, but it failed, was too complicated to investigate/solve.
- This is still on backlog, if I can manage to have access to a Mac in order to fix the build I will work on this. Any external help is always welcome.
- My next attempt will be using the plugin "Code with me" and asking a friends help. This is on backlog already.


### IDE issues
I've experienced the IDE AndroidStudio Bumblebee showing false messages about compilations issues of the module "platforms".
This must be related to the way the plugins are defined, but the project succeeds to sync and compile.
If that's your case, close the project, delete ".idea" folder from root project then reopen it.


## About the team
- Me, Myself & I.
- Since I'm a developer, the processes to build this app are different from usual companies.
  - There is a board to register the next steps
  - This is projected to have only me and my girlfriend as users
  - Design preview is just a scratch on a paper
  - I develop based on what comes to my mind. Sometimes it's organizing the project, other times it's rushing a new feature. There's also a lot of researches about new libs.
  - My target is to have a MVP running on multiplatforms and use it to show my knowledge and programming skills.
  - I'm not using TDD until the project setup is done. This includes managing modules structures, libraries definitions and basic app running. For new features I expect to have automated tests covering main parts of the app.
  - It's been a great pleasure to develop this. I hope you enjoy :)
