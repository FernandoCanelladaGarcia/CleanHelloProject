package es.ulpgc.eite.clean.mvp.sample.hello;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

public class HelloView
    extends GenericActivity<Hello.PresenterToView, Hello.ViewToPresenter, HelloPresenter>
    implements Hello.PresenterToView {

  private Toolbar toolbar;
  private Button btnSayHelloView, btnGoToByeView;
  private TextView helloMsgView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hello);

    helloMsgView = (TextView) findViewById(R.id.text);

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    btnSayHelloView = (Button) findViewById(R.id.sayHelloBtn);
    btnSayHelloView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getPresenter().onSayHelloBtnClicked();
      }
    });

    btnGoToByeView = (Button) findViewById(R.id.goToByeBtn);
    btnGoToByeView.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick (View view){
        getPresenter().onGoToByeBtnClicked();
      }
    });
  }

  /**
   * Method that initialized MVP objects
   * {@link super#onResume(Class, Object)} should always be called
   */
  @Override
  protected void onResume() {
    super.onResume(HelloPresenter.class, this);
  }

  /*
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_hello, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up btnSayHelloView, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
  */


  ///////////////////////////////////////////////////////////////////////////////////
  // Presenter To View /////////////////////////////////////////////////////////////

  @Override
  public void finishScreen() {
    finish();
  }

  @Override
  public void hideToolbar() {
    toolbar.setVisibility(View.GONE);
  }

  @Override
  public void hideHelloMsg() {
    helloMsgView.setVisibility(View.GONE);
  }

  @Override
  public void showHelloMsg() {
  helloMsgView.setVisibility(View.VISIBLE);
  }



  @Override
  public void showText() {
    helloMsgView.setVisibility(View.VISIBLE);
  }

  @Override
  public void setHelloMsg(String txt) {
    helloMsgView.setText(txt);
  }

  @Override
  public void setSayHelloBtnLabel(String txt) {
    btnSayHelloView.setText(txt);
  }

  @Override
  public void setGoToByeBtnLabel(String txt) {
    btnGoToByeView.setText(txt);

  }
}
