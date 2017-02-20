package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.sample.dummy.DummyView;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.hello.HelloView;
import es.ulpgc.eite.clean.mvp.sample.bye.Bye;
import es.ulpgc.eite.clean.mvp.sample.bye.ByeView;


public class App extends Application implements Mediator, Navigator {

  private DummyState toDummyState, dummyToState;
  private HelloState toHelloState, helloToState;
  private ByeState toByeState, byeToState;

  @Override
  public void onCreate() {
    super.onCreate();
    toDummyState = new DummyState();
    toDummyState.toolbarVisibility = false;
    toDummyState.textVisibility = false;
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Mediator //////////////////////////////////////////////////////////////////////

  @Override
  public void startingDummyScreen(Dummy.ToDummy presenter){
    if(toDummyState != null) {
      presenter.setToolbarVisibility(toDummyState.toolbarVisibility);
      presenter.setTextVisibility(toDummyState.textVisibility);
    }
    presenter.onScreenStarted();
  }

  @Override
  public void startingHelloScreen(Hello.ToHello presenter){
    if(toHelloState != null) {
      presenter.setToolbarVisibility(toHelloState.toolbarVisibility);
      presenter.setTextVisibility(toHelloState.textVisibility);
    }
    presenter.onScreenStarted();
  }

  @Override
  public void startingByeScreen(Bye.ToBye presenter){
    if(toByeState != null) {
      presenter.setToolbarVisibility(toByeState.toolbarVisibility);
      presenter.setTextVisibility(toByeState.textVisibility);
    }
    presenter.onScreenStarted();
  }


  ///////////////////////////////////////////////////////////////////////////////////
  // Navigator /////////////////////////////////////////////////////////////////////


  @Override
  public void goToNextScreen(Dummy.DummyTo presenter) {
    dummyToState = new DummyState();
    dummyToState.toolbarVisibility = presenter.isToolbarVisible();
    dummyToState.textVisibility = presenter.isTextVisible();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, DummyView.class));
      presenter.destroyView();
    }

  }

  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  private class DummyState {
    boolean toolbarVisibility;
    boolean textVisibility;
  }

  private class HelloState {
    boolean toolbarVisibility;
    boolean textVisibility;
  }

  private class ByeState {
    boolean toolbarVisibility;
    boolean textVisibility;
  }

}
