#!/usr/bin/env amm

import $file.jfx

import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.Includes._
import scalafx.geometry.Insets
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.layout.{BorderPane, HBox, Priority}
import scalafx.scene.web.WebView

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage

import scala.language.implicitConversions

@main
def main() {
  WebViewSample.main(Array())
}

object WebViewSample extends JFXApp3 {
  override def start(): Unit = {
    stage = new PrimaryStage {
        title = "Web View Example"
        width = 1020
        height = 700
        scene = new Scene {
          root = {
            // Default URL to load at first
            val defaultURL = "http://www.scala-lang.org/"
            val locationField = new TextField {
              text = defaultURL
              hgrow = Priority.Always
            }
            val goButton = new Button {
              text = "Go"
              defaultButton = true
            }
            val webView = new WebView {
              // Update location field is page is redirected
              engine.location.onChange((_, _, newValue) => locationField.setText(newValue))
              // Load default page
              engine.load(defaultURL)
            }

            def validUrl(url: String) = if (url.startsWith("http://")) url else "http://" + locationField.text()

            val loadAction = () => webView.engine.load(validUrl(locationField.text()))
            goButton.onAction = loadAction
            locationField.onAction = loadAction

            new BorderPane {
              padding = Insets(5)
              top = new HBox {
                spacing = 5
                margin = Insets(top = 0, right = 0, bottom = 5, left = 0)
                children = List(locationField, goButton)
              }
              center = webView
            }
          }
        }
      }
  }
}
