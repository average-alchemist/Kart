# Kart
Kart is simple android application which uses [**Dummy JSON API**](https://dummyjson.com/) to serve as simple demo e-commerce application that demonstrates different ways of communicating with the backend services. In its current implementation it uses Retrofit and Ktor client.

## Screens
![kart_example](https://user-images.githubusercontent.com/30006970/235842818-36e59fe8-8b07-4eec-97a7-b7fbd890f730.jpg)

## Disclaimer
The main purpose of the project is to, as description mentions, demonstrate different ways to communicate with the backend services without going into too much detail. So you, as a developer, should only focus on couple of files within this project to get going with your own. It's not here to demonstrate how Jetpack Compose works, how use-cases are laid out; it's purely for simple Retrofit/Ktor client setup to get you going.

## Install

Clone the repository, and run the project, no additional setup is needed. Simple as that. Main branch uses Retrofit, but you can select which config you want to use by switching to different branch.

## Retrofit
If you opt out for using this pretty standard networking library, you might want to explore following files:
1. [DummyApiService](https://github.com/primepixel/Kart/blob/main/app/src/main/java/io/aethibo/kart/features/shared/data/remote/api/DummyApiService.kt) - which declares different API calls that you might want to use within your application. Not every Retrofit part is covered, so might want to extend that knowledge via its official documentation.
2. [ProductsModule](https://github.com/primepixel/Kart/blob/main/app/src/main/java/io/aethibo/kart/features/shared/data/di/ProductsModule.kt) - here we provide all things we need data related (from API calls, to use-cases). This is important since we inject DummyApiService into repository implementation.
3. [NetworkModule](https://github.com/primepixel/Kart/blob/main/app/src/main/java/io/aethibo/kart/core/network/NetworkModule.kt) - here we provide retrofit instance along with some additional configuration.

## Ktor client
If you opt out for using this newer, but equally powerful networking library, you might want to explore following files:
1. [ProductsRemoteDatasourceImpl](https://github.com/primepixel/Kart/blob/feature/ktor/app/src/main/java/io/aethibo/kart/features/shared/data/remote/ProductsRemoteDatasourceImpl.kt) - here we utilize ktor client to fetch body of our requests given the specific URL. Not every Ktor client part is covered, so might want to extend that knowledge via its official documentation.
2. [ProductsModule](https://github.com/primepixel/Kart/blob/main/app/src/main/java/io/aethibo/kart/features/shared/data/di/ProductsModule.kt) - here we provide all things we need data related (from API calls, to use-cases). This is important since we inject remote data service into repository implementation.
3. [NetworkModule](https://github.com/primepixel/Kart/blob/main/app/src/main/java/io/aethibo/kart/core/network/NetworkModule.kt) - here we provide ktor instance along with some additional configuration.

## Contribute

If you want to contribute to this repository, you're always welcome!

## Contact

If you need any help, feel free to contact me: kenan.karic@outlook.com.

## License
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
