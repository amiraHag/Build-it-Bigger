package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

        MainActivity mainActivity;
        final CountDownLatch latch = new CountDownLatch(1);


    @Test
    public void doInBackground() throws InterruptedException {
        mainActivity = new MainActivity();
       mainActivity.isTestRun = true;
       EndpointAsyncTask testJokeAsyncTask = new EndpointAsyncTask();

        testJokeAsyncTask.execute();
        Thread.sleep(1000);
        assertNotNull("The Joke " + mainActivity.mTestJoke);
    }


    @Test
    public void onPostExecute() {

      //  assertEquals("Joke", mainActivityFragment.mTestJoke);


    }






}