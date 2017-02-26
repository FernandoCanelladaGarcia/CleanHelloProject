package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.dummy.Dummy;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
public interface Navigator {
  void goToNextScreen(Dummy.DummyTo presenter);

  void goToByeScreen(Hello.HelloToBye presenter);
}
