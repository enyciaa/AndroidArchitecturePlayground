### AndroidArchitecturePlayground
This series takes a basic MVP app using Retrofit and RxJava to display a list of Github repositories; and converts it into a modern Android app - along the way it will give an introduction to a variety of techniques used when architecting Android apps, explain why those techniques are used, and perform a few experiments.

#### Starting point 
[Link to snapshot](https://github.com/enyciaa/AndroidArchitecturePlayground/tree/1.0.0)  
The app fetches github repositories for a user, shows further details about the repository, and allows navigation to the actual repository.

The apps is built in Kotlin and architected with a simple version of MVP. It also uses Retrofit and RxJava. Beyond that, it doesn't have 
much.

#### Simple dependency injection 
[Link to snapshot](https://github.com/enyciaa/AndroidArchitecturePlayground/tree/1.1.0)  
Adds a basic form of dependency injection with dagger. DI is only used for object creation - fancy features arn't included.

#### Converting MVP to MVVM 
[Link to snapshot](https://github.com/enyciaa/AndroidArchitecturePlayground/tree/1.2.0)  
Converts the MVP pattern into a basic version of MVVM. No supporting libraries - such as LiveData, Lifecycle, and ViewModel are used ot achieve this.

#### Single activity architecture
[Link to snapshot](https://github.com/enyciaa/AndroidArchitecturePlayground/tree/1.3.0)  
Converts the app to use Google suggested single activity architecture supported by the navigation androidx library. Plus makes use of a
 funky DI pattern to abstract UI code.
