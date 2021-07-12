#!/usr/bin/env amm

import $file.jfx

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint._
import scalafx.scene.text.Text

import scala.language.implicitConversions

@main
def main() {
  JFXApp3Demo.main(Array())
}

object JFXApp3Demo extends JFXApp3 {
  override def start(): Unit = {
    stage = new PrimaryStage {
      title = "ScalaFX Hello World!"
      scene = new Scene {
        fill = Color.rgb(38, 38, 38)
        content = new HBox {
          padding = Insets(50, 80, 50, 80)
          children = Seq(
            new Text {
              text = "Hello World!"
              style = "-fx-font: normal bold 100pt sans-serif"
              fill = new LinearGradient(endX = 0, stops = Stops(Red, DarkRed))
            }
          )
        }
      }
    }
  }
}
