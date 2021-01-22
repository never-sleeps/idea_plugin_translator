### Plugin for text translation in Intellij IDEA

Select the text in your code and double-click the `⌘ + BACK_SLASH`. It will open https://translate.google.com with your text.

#### Testing the result:
1. Clone the repo: git clone https://github.com/never-sleeps/idea_plugin_translator.git
2. Open the repo directory in a console
3. Build the plugin: gradlew buildPlugin
4. Test the plugin: gradlew runIde
5. YOU ARE PERFECT!

#### Running on a production instance of IDEA without publishing the plugin:
0. Follow the steps above
1. Intellij IDEA > Preferences > Plugins > Install Plugin From Disc...
2. Find the directory with your jar: translator_plugin/build/libs/translator_plugin-1.0.0.jar
3. Restart IDEA
5. YOU ARE PERFECT!
