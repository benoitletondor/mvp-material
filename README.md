# MVP Material

[ ![Download](https://api.bintray.com/packages/benoitletondor/maven/mvp-material/images/download.svg) ](https://bintray.com/benoitletondor/maven/mvp-material/_latestVersion)

MVP Material is an Android library that contains MVP implementation for support design library components. This library is an extend of the base [MVPCore](https://github.com/benoitletondor/mvp-core) library.

## Concept

This is a library I built essentially for my own use to work with components from the design support library using my MVP implementation.

Currently, it provides MVP implementation for `BottomSheetDialogFragment` and more can be added in the future.

**If you are unfamiliar with the concept of MVP or the base MVP library, please check the [Base MVP library](https://github.com/benoitletondor/mvp-core).**

## Dependencies

This library provides implementation for views that use the [design support library](https://developer.android.com/topic/libraries/support-library/features.html). It has a strong dependency on it. 

## How to use

**Add this line to your gradle file:**

```
compile 'com.benoitletondor:mvp-material:0.1'
```

To use it, make your views implementation, the `BottomSheetDialogFragment` for example, extend the base classes provided into this library.

More details are available into the [Base MVP library](https://github.com/benoitletondor/mvp-core).

## TODO

I still have to implement Junit and Espresso tests and run them with Travis, that's the reason it's 0.1 and not 1.0 yet.

## License

    Copyright 2018 Benoit LETONDOR

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.