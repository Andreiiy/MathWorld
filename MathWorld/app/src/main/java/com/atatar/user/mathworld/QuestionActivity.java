package com.atatar.user.mathworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.atatar.user.mathworld.Adapter.AnswerSheetAdapter;
import com.atatar.user.mathworld.Adapter.QuestionFragmentAdapter;
import com.atatar.user.mathworld.Common.Common;
import com.atatar.user.mathworld.DbHelper.Data;
import com.atatar.user.mathworld.Model.CurrentQuestion;


public class QuestionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    int time_lay = Common.TOTAL_TIME;
    boolean  isAnswerModeView = false;
    CountDownTimer countDownTimer;

    TextView txt_right_answer, txt_timer, txt_wrong_answer;

    RecyclerView answer_sheet_view;
    AnswerSheetAdapter answerSheetAdapter;

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onDestroy() {

        if(countDownTimer != null)
            countDownTimer.cancel();
        super.onDestroy();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(Common.selectedCategory);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        takeQuestion();

        if(Common.questionList.size() > 0) {

            txt_right_answer=(TextView)findViewById(R.id.text_question_right);
            // txt_timer=(TextView)findViewById(R.id.tx);

            // txt_right_answer.setVisibility(View.VISIBLE);
            // txt_timer .setVisibility(View.VISIBLE);


            answer_sheet_view = (RecyclerView) findViewById(R.id.grid_answer);
            answer_sheet_view.setHasFixedSize(true);
            if (Common.questionList.size() > 1)
                answer_sheet_view.setLayoutManager(new GridLayoutManager(this, Common.questionList.size()/2 ));
            answerSheetAdapter = new AnswerSheetAdapter(this, Common.answerSheetList);
            answer_sheet_view.setAdapter(answerSheetAdapter);


            viewPager = (ViewPager)findViewById(R.id.viewpager);
            tabLayout = (TabLayout)findViewById(R.id.sliding_tabs);

            genFragmentList();

            QuestionFragmentAdapter questionFragmentAdapter = new QuestionFragmentAdapter(
                    getSupportFragmentManager(),
                    this, Common.fragmentsList);

            viewPager.setAdapter(questionFragmentAdapter);
            tabLayout.setupWithViewPager(viewPager);


            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                int SCROLLING_RIGHT = 0;
                int SCROLLING_LEFT = 1;
                int SCROLLING_UNDETERMINED = 2;

                int currentScrollDirection = 2;

                private void setScrollingDirection(float positionOffset){
                    if(1 - positionOffset >= 0.5)
                        this.currentScrollDirection = SCROLLING_RIGHT;
                    else if(1 - positionOffset <= 0.5)
                        this.currentScrollDirection = SCROLLING_LEFT;
                }

                private boolean isScrollDirectionUndetermined(){
                    return currentScrollDirection == SCROLLING_UNDETERMINED;
                }
                private boolean isScrollingLeft(){
                    return currentScrollDirection == SCROLLING_LEFT;
                }
                private boolean isScrollingRight(){
                    return currentScrollDirection == SCROLLING_RIGHT;
                }
                @Override
                public void onPageScrolled(int i, float v, int i1) {
                    if(isScrollDirectionUndetermined())
                        setScrollingDirection(v);
                }

                @Override
                public void onPageSelected(int i) {

                    QuestionFragment questionFragment;
                    int position = 0;
                    if(i>0){
                        if(isScrollingRight()){
                            questionFragment = Common.fragmentsList.get(i-1);
                            position = i - 1;
                        }
                        else if(isScrollingLeft()){
                            questionFragment = Common.fragmentsList.get(i + 1);
                            position = i + 1;
                        }
                        else {
                            questionFragment = Common.fragmentsList.get(position);
                        }
                    }
                    else {
                        questionFragment = Common.fragmentsList.get(0);
                        position = 0;
                    }

                    CurrentQuestion question_state = questionFragment.getSelectedAnswer();
                    Common.answerSheetList.set(position,question_state);
                    answerSheetAdapter.notifyDataSetChanged();

                    countCorrectAnswer();

                    txt_right_answer.setText(new StringBuilder(String.format("%d",Common.right_answer_count))
                            .append("/")
                            .append(String.format("%d",Common.questionList.size())).toString());

                    // txt_wrong_answer.setText(String.valueOf(Common.wrong_answer_count));

                    if(question_state.getType() == Common.ANSWER_TYPE.NO_ANSWER){
                        questionFragment.showCorrectAnswer();
                        questionFragment.disableAnswer();
                    }
                }

                @Override
                public void onPageScrollStateChanged(int i) {
                    if(i == ViewPager.SCROLL_STATE_IDLE)
                        this.currentScrollDirection = SCROLLING_UNDETERMINED;
                }
            });


        }
    }

    private void countCorrectAnswer() {
        Common.right_answer_count = Common.wrong_answer_count = 0;
        for(CurrentQuestion item:Common.answerSheetList){
            if(item.getType() == Common.ANSWER_TYPE.RIGHT_ANSWER)
                Common.right_answer_count++;
            else if(item.getType() == Common.ANSWER_TYPE.WRONG_ANSWER)
                Common.wrong_answer_count++;

        }
    }

    private void genFragmentList() {
         if(Common.fragmentsList.size() > 0) {
             Common.fragmentsList.clear();
             Common.right_answer_count = Common.wrong_answer_count = 0;
         }
        for(int i = 0; i < Common.questionList.size();i++){

            Bundle bundle = new Bundle();
            bundle.putInt("index",i);
            QuestionFragment fragment = new QuestionFragment();
            fragment.setArguments(bundle);

            Common.fragmentsList.add(fragment);
        }
    }



    private void takeQuestion(){
        Data data = new Data(this);
        Common.questionList = data.getQuestions(Common.idSelectedCategory);

        if(Common.answerSheetList.size() > 0)
            Common.answerSheetList.clear();

        for(int i=0;i<Common.questionList.size();i++)
            Common.answerSheetList.add(new CurrentQuestion(i,Common.ANSWER_TYPE.NO_ANSWER));

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_finish_game) {
            if(!isAnswerModeView){
                Intent intent = new Intent(this,FinishActivity.class);
                startActivity(intent);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
