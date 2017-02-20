package es.ulpgc.eite.clean.mvp.sample.hello;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;


public class HelloModel extends GenericModel<es.ulpgc.eite.clean.mvp.sample.hello.Hello.ModelToPresenter>
    implements es.ulpgc.eite.clean.mvp.sample.hello.Hello.PresenterToModel {

  private String helloText;
  private String helloLabel;
  private int numOfTimes;
  private String msgText;

  /**
   * Method that recovers a reference to the PRESENTER
   * You must ALWAYS call {@link super#onCreate(Object)} here
   *
   * @param presenter Presenter interface
   */
  @Override
  public void onCreate(Hello.ModelToPresenter presenter) {
    super.onCreate(presenter);

    helloLabel = "Click Me!";
    helloText = "Hello World!";
  }

  /**
   * Called by layer PRESENTER when VIEW pass for a reconstruction/destruction.
   * Usefull for kill/stop activities that could be running on the background Threads
   *
   * @param isChangingConfiguration Informs that a change is occurring on the configuration
   */
  @Override
  public void onDestroy(boolean isChangingConfiguration) {

  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Presenter To Model ////////////////////////////////////////////////////////////


  @Override
  public void onChangeMsgByBtnClicked() {
    msgText = helloText;
    if(numOfTimes > 0) {
      msgText += ", " + numOfTimes + " times";
    }
    numOfTimes++;
  }

  @Override
  public String getText() {
    return msgText;
  }

  @Override
  public String getLabel() {
    return helloLabel;
  }
}
