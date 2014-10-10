WebView? Really?
================
A handy custom [Android lint](http://tools.android.com/tips/lint) rule that helps you recognize when you're using [WebViews](https://developer.android.com/reference/android/webkit/WebView.html) in your app, so [you](http://highscalability.com/blog/2014/9/29/instagram-improved-their-apps-performance-heres-how.html) [can](http://www.idownloadblog.com/2014/07/31/wikipedia-for-iphone/) [switch](http://venturebeat.com/2013/04/17/linkedin-mobile-web-breakup/) [back](http://www.theregister.co.uk/2012/12/13/facebook_native_app_for_android/) [to](http://www.fastcolabs.com/3030873/our-html5-web-app-flopped-so-we-went-native-and-havent-looked-back) [native](http://blog.gqueues.com/2013/02/eating-my-own-words-gqueues-switches.html). [Your users will like it.](http://www.eweek.com/mobile/americans-prefer-native-mobile-apps-over-html-survey/)

Installation
============
Copy the [compiled jar](WebViewReally-1.0.jar) to your `.android/lint` directory.

Usage
=====
```
$ lint Dumb/app/src/main/res/layout/activity_my.xml 

Scanning main: .
res/layout/activity_my.xml:11: Warning: WebView? Really? These are performance hogs. [WebViewsAreDumb1]
    <WebView
    ^
0 errors, 1 warnings
```