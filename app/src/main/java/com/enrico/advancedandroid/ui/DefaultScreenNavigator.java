package com.enrico.advancedandroid.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.enrico.advancedandroid.details.RepoDetailsController;
import com.enrico.advancedandroid.di.ActivityScope;

import javax.inject.Inject;

/**
 * Created by enrico on 3/6/18.
 */

public class DefaultScreenNavigator implements ScreenNavigator {

    private Router mRouter;

    @Inject
    DefaultScreenNavigator() {

    }

    @Override
    public void initWithRouter(Router router, Controller rootScreen) {
        mRouter = router;
        if (!mRouter.hasRootController()) {
            mRouter.setRoot(RouterTransaction.with(rootScreen));
        }
    }

    @Override
    public boolean pop() {
        return mRouter != null && mRouter.handleBack();
    }

    @Override
    public void goToRepoDetails(String repoOwner, String repoName) {
        if (mRouter != null) {
            mRouter.pushController(
                    RouterTransaction.with(RepoDetailsController.newInstance(repoName, repoOwner))
                            .pushChangeHandler(new FadeChangeHandler())
                    .popChangeHandler(new FadeChangeHandler())
            );
        }
    }

    @Override
    public void clear() {
        mRouter = null;
    }
}
