import { async, ComponentFixture, fakeAsync, TestBed, tick } from "@angular/core/testing";
import { FormsModule } from "@angular/forms";
import { ActivatedRoute } from "@angular/router";
import { AppModule } from "src/app/app.module";
import { UserService } from "src/app/services/user.service";
import { LoginComponent } from "./login.component";
import { of } from "rxjs";
import { HttpClientModule } from "@angular/common/http";



const routerSpy = jasmine.createSpyObj('Router', ['navigateByUrl']);
//const userServiceSpy = jasmine.createSpyObj('UserService', ['login']);
const activatedRouteSpy = jasmine.createSpyObj('ActivatedRoute', ['snapshot']);
const testUserData = { email: 1, password: 'TekLoon', remembered:false};





describe('Login Component test', ()=>{
    let component : LoginComponent;
    let fixture: ComponentFixture<LoginComponent>;
    let spy;
    let service :UserService;

    beforeEach(() => {
        TestBed.configureTestingModule({
          imports: [AppModule,HttpClientModule],
          providers: [
            {provide: UserService},
            
          //  { provide: Router, useValue: routerSpy }
          ],
        })
        .compileComponents();
     
      });

   
  beforeEach(async(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component= fixture.componentInstance;
    fixture.detectChanges();
  

    // loginSpy = userServiceSpy.login.and.returnValue(Promise.resolve(testUserData));
  }));


  it('Component successfully created', () => {
    expect(component).toBeTruthy();
  });

  it('component initial state', () => {
    expect(component.submitted).toBeFalsy();
    expect(component.model.username).toEqual('');
    expect(component.model.password).toEqual('')
  });

  it('should not valid', () => {
    console.log(component.ngForm.form.controls)
    expect(component.ngForm.form.valid).not.toBeTruthy();
  });

  it('email and password validation for required filed', ()=>{
    fixture.whenStable().then(() => {
      const ctrl = component.ngForm.form.get('email');
      expect(ctrl.valid).toBe(false);
  });
})

it('email and password validation for required filed', ()=>{
  fixture.whenStable().then(() => {
    const ctrl = component.ngForm.form.get('password');
    expect(ctrl.valid).toBe(false);
});
})


it('email validation for required filed', ()=>{
  fixture.whenStable().then(() => {
    const ctrl: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#email');
    ctrl.dispatchEvent(new Event('focus'));
    ctrl.dispatchEvent(new Event('blur'));
    fixture.detectChanges();
    fixture.whenStable().then(()=>{
      const emailError: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#emailError');

      expect(emailError.children.length).toEqual(0);
      expect(emailError.innerHTML).toEqual(' Email is required ');

    })  
});
})




it('submit button validation for disabled condition', ()=>{
  fixture.whenStable().then(() => {
    const ctrl: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#password');
    const submitButton: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#submitButton');
    ctrl.dispatchEvent(new Event('focus'));
    ctrl.dispatchEvent(new Event('blur'));
    fixture.detectChanges();
    fixture.whenStable().then(()=>{
      const passwordError: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#passwordError');

      expect(passwordError.children.length).toEqual(0);
      expect(passwordError.innerHTML).toEqual(' Password is required ');
      expect(submitButton.disabled).toBeTruthy();

    })  
});
})

it('submit button validation for enabled condition', ()=>{
  fixture.whenStable().then(() => {
    const email: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#email');
    const password: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#password');
    const submitButton: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#submitButton');
    email.value ="aaaa";
    password.value = "sssrer";

    email.dispatchEvent(new Event('input'));
    password.dispatchEvent(new Event('input'));
    console.log(component.ngForm.form.get('password'))
    fixture.detectChanges();
    fixture.whenStable().then(()=>{ 
      expect(submitButton.disabled).toBeFalsy();

    })  
});

})

it('submit button validation for enabled condition2222', ()=>{
  fixture.whenStable().then(() => {
    service = TestBed.get(UserService);
    const email: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#email');
    const password: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#password');
    const submitButton: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#submitButton');
    email.value ="raja";
    password.value = "sssrer";

    email.dispatchEvent(new Event('input'));
    password.dispatchEvent(new Event('input'));
    console.log(component.ngForm.form.get('password'))
    fixture.detectChanges();

    let ss = fixture.debugElement.injector.get(UserService);
    spyOn(ss,"currentUserValue").and.callFake(()=>{
      return of({
        "result":200
      })
    }) ;
    component.onSubmit();
    expect(ss.currentUserValue).toHaveBeenCalled();
    expect(component.returnUrl).toEqual("/")
});

})


});

// describe('Login Component Integrated Test', () => {
//   let fixture: ComponentFixture<LoginComponent>;
//   let loginSpy;
//   let component : LoginComponent;
//   function updateForm(userEmail, userPassword) {
//     console.log(userEmail)
//     fixture.debugElement.nativeElement.querySelector('#email').value(userEmail);
//     fixture.debugElement.nativeElement.querySelector('#passowrd').value(userPassword);
//   }

//   beforeEach(async(() => {
//     TestBed.configureTestingModule({
//       imports: [AppModule],
//       providers: [
//         {provide: UserService, useValue: userServiceSpy},
        
//         //{ provide: Router, useValue: routerSpy }
//       ],
//       declarations: [LoginComponent],
//     }).compileComponents();

//     fixture = TestBed.createComponent(LoginComponent);
//     // router = TestBed.get(Router);

//     loginSpy = userServiceSpy.login.and.returnValue(Promise.resolve(testUserData));
//      component = fixture.componentInstance;
//       fixture.detectChanges();

//   }));

//   it('loginService login() should called ', fakeAsync(() => {
//     updateForm('raja', "4444");
//     fixture.detectChanges();
//     const button = fixture.debugElement.nativeElement.querySelector('#submitButton');
//     button.click();
//     fixture.detectChanges();
//     tick();

//     expect(userServiceSpy.login).toHaveBeenCalled();
    
//   }));


// });





