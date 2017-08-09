package com.example.coviam.daggersimpleexample.dagger;

import android.content.Context;
import com.example.coviam.daggersimpleexample.DemoClass;
import com.example.coviam.daggersimpleexample.DemoClass2;
import com.example.coviam.daggersimpleexample.DemoClass_Factory;
import com.example.coviam.daggersimpleexample.MainActivity;
import com.example.coviam.daggersimpleexample.MainActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<Context> provideContextProvider;

  private Provider<DemoClass> demoClassProvider;

  private Provider<Context> getContextProvider;

  private Provider<DemoClass2> provideDemoClassProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideContextProvider =
        ActivityModule_ProvideContextFactory.create(builder.activityModule);

    this.demoClassProvider = DemoClass_Factory.create(provideContextProvider);

    this.getContextProvider = ActivityModule_GetContextFactory.create(builder.activityModule);

    this.provideDemoClassProvider =
        ActivityModule_ProvideDemoClassFactory.create(builder.activityModule, getContextProvider);

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(demoClassProvider, provideDemoClassProvider);
  }

  @Override
  public void inject(MainActivity mainActivity) {
    mainActivityMembersInjector.injectMembers(mainActivity);
  }

  public static final class Builder {
    private ActivityModule activityModule;

    private Builder() {}

    public ActivityComponent build() {
      if (activityModule == null) {
        throw new IllegalStateException(ActivityModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder activityModule(ActivityModule activityModule) {
      this.activityModule = Preconditions.checkNotNull(activityModule);
      return this;
    }
  }
}
