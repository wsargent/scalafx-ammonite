#!/usr/bin/env amm

import $file.jfx
import $cp.sfxml

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage

import java.io.IOException
import scalafx.Includes._
import scalafx.scene.Scene

import scalafx.event.ActionEvent
import scalafx.scene.control.{ChoiceBox, TextArea, TextField}
import scalafx.scene.layout.GridPane

import javafx.{fxml => jfxf, scene => jfxs}
import javafx.scene.{control => jfxsc, layout => jfxsl}
import javafx.{event => jfxe}
import java.net.URL
import java.util.ResourceBundle

@main
def main() {
  FXMLAdoptionForm.main(Array())
}

/** Example of using FXMLLoader from ScalaFX.
  *
  * From https://github.com/scalafx/ProScalaFX/blob/master/src/proscalafx/ch10/fxml/FXMLAdoptionForm.scala
  *
  * @author Jarek Sacha
  */
object FXMLAdoptionForm extends JFXApp3 {

  override def start(): Unit = {
    // Possible because the shebang defines interp.load.cp using predef up top :-)
    val resource = getClass.getResource("/AdoptionForm.fxml")
    if (resource == null) {
      throw new IOException("Cannot load resource: AdoptionForm.fxml")
    }

    val root:jfxs.Parent = jfxf.FXMLLoader.load(resource)
    stage = new PrimaryStage() {
      title = "FXML GridPane Demo"
      scene = new Scene(root)
    }
  }
}

class AdoptionFormController extends jfxf.Initializable {

  @jfxf.FXML
  private var sizeTextField: jfxsc.TextField = _
  @jfxf.FXML
  private var breedTextField: jfxsc.TextField = _
  @jfxf.FXML
  private var sexChoiceBox: jfxsc.ChoiceBox[String] = _
  @jfxf.FXML
  private var additionalInfoTextArea: jfxsc.TextArea = _

  @jfxf.FXML
  private var gridDelegate: jfxsl.GridPane = _
  private var grid: GridPane = _

  @jfxf.FXML
  private def handleSubmit(event: jfxe.ActionEvent): Unit = {
    grid.gridLinesVisible() = !grid.gridLinesVisible()
  }

  @jfxf.FXML
  private def handleClear(event: jfxe.ActionEvent): Unit = {
    sizeTextField.text = ""
    breedTextField.text = ""
    sexChoiceBox.selectionModel().clearSelection()
    additionalInfoTextArea.text = ""
  }

  def initialize(url: URL, rb: ResourceBundle): Unit = {
    grid = new GridPane(gridDelegate)
  }
}
