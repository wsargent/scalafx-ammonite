# ScalaFX with Ammonite

[Ammonite](https://ammonite.io) is a script tool for Scala.

[ScalaFX](http://www.scalafx.org/) is a framework providing a DSL for [JavaFX](https://openjfx.io/), providing a GUI interface.

With their powers combined, you can script GUI tools using Scala, without having to run sbt or any kind of build process.

## Requirements

Install JDK 16 -- I've been using sdkman with 16.0.1.9.1-amzn, YMMV

```
sdk install java 16.0.1.9.1-amzn
```

Install [amm](https://ammonite.io/#ScalaScripts):

```
sudo sh -c '(echo "#!/usr/bin/env sh" && curl -L https://github.com/com-lihaoyi/Ammonite/releases/download/2.4.0/2.13-2.4.0) > /usr/local/bin/amm && chmod +x /usr/local/bin/amm' && amm
```

## Usage

Clone or download this project, and then run the script:

```
amm ./helloworld.sc
```

You should see a "Hello World" GUI box show up.

For a more complex example, you can see the AdoptionForm, which uses FXML:

```
amm ./adoption.sc
```

You can also run a browser from ScalaFX:

```
amm ./webbrowser.sc
```

This unfortunately crashes on Windows WSL, but may work on your platform.
