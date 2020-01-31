### AndroidArchitecturePlayground
This series takes a basic MVP app displaying a list of Github repositories; and converts it into a modern Android app - along the way it 
will give an introduction to a variety of techniques used when architecting Android apps and explain why those techniques are used.

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
