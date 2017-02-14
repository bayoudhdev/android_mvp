App based on Material Design + MVP + Retrofit 2 + Okhttp + (Custom Lib Permission android 6)Edit
Context :
The project is based on the idea of simplicity, make development more simple, extract the core library, can be directly introduced to fast development.

Edit
Points :
Use Retrofit2 OKHTTP to do network requests and caching
Use Material Design controls and animations
Use RxPermissions for android6.0 permission application
Use the MVP architecture throughout the project, and extract the core as a library, import core can save 50% of the code development
Use Fragmentation to simplify the operation of Fragment and lazy loading
Edit
Dependencies :Edit
Method of use
Import the core library
compile "com.android.support:appcompat-v7:${libs.supportVersion}"
compile "com.jakewharton:butterknife:${libs.butterknife}"
apt "com.jakewharton:butterknife-compiler:${libs.butterknife}"
compile "uk.co.chrisjenx:calligraphy:${libs.calligraphy}"
compile "com.squareup.okhttp3:logging-interceptor:${libs.interceptor}"
compile "com.squareup.retrofit2:retrofit:${libs.retrofit}"
compile "com.squareup.retrofit2:converter-gson:${libs.retrofit}"
compile "com.squareup.retrofit2:converter-scalars:${libs.retrofit}"

Edit
Gradle Settings :
ext {
configuration = [
package : "com.mvp.project",
buildToolsVersion: "25.0.0",
compileVersion : 24,
minSdk : 17,
targetSdk : 25,
version_code : 1,
version_name : "1.0"
]

libraries = [
            supportVersion: "25.1.0",
            butterknife   : "8.4.0",
            calligraphy   : "2.2.0",
            retrofit      : "2.1.0",
            interceptor   : "3.2.0"
    ]
keystore = [
            keyPassword  : "",
            storePassword: "",
            alias        : "",
            path         : ""
    ]
}
Edit
TODO
-Add Dagger 2, EventBus , RXJAVA
-Continue to optimize
-There are many to do...# android_mvp
