import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {ListComponent} from './list/list.component';
import {CartComponent} from './cart/cart.component';
import {RouterModule} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {SecurityModule} from './security/security.module';
import {GoogleLoginProvider, SocialAuthServiceConfig, SocialLoginModule} from 'angularx-social-login';

const googleLoginOptions = {
  scope: 'profile email',
  plugin_name: 'login'
};

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ListComponent,
    CartComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    RouterModule,
    HttpClientModule,
    SecurityModule,
    SocialLoginModule
  ],
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '612774287153-uthnsrl25on17doe8413il68ebv9c969.apps.googleusercontent.com',
              googleLoginOptions
            )
          },
        ]
      } as SocialAuthServiceConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
