// import { async, ComponentFixture, fakeAsync, TestBed } from "@angular/core/testing";
// import { FormsModule, Validators } from "@angular/forms";
// import { RouterModule } from "@angular/router";
// import { AppModule } from "src/app/app.module";
// import { SignupComponent } from "./signup.component";
// //import { RouterTestingModule } from '@angular/router/testing';

// describe('Signup Component test', ()=>{
//     let component : SignupComponent;
//     let fixture: ComponentFixture<SignupComponent>;

//     beforeEach(async(() => {
//         //component = new LoginComponent(userServiceSpy, routerSpy, activatedRouteSpy );
//         TestBed.configureTestingModule({
//         imports: [
//           AppModule
//         ]
//         }).compileComponents();
//     }));

//     beforeEach(async(() => {
//         fixture = TestBed.createComponent(SignupComponent);
//         component = fixture.componentInstance;
//         component.ngOnInit();
//         fixture.detectChanges();
//     }));
  
//     it('should be valid', () => {
//         console.log(component.ngForm.form.controls)
//         expect(component.ngForm.form.valid).toBeFalsy();
//     });

//     it('Test form group element count',() => {
//         const formElement = fixture.debugElement.nativeElement.querySelector('#signUpForm');
//         const inputElements = formElement.querySelectorAll('input');
//         expect(inputElements.length).toEqual(5);
//     });

//     it('validation for required feild and submit Button DISABLED is False', () =>{
//         const emailElement: HTMLElement = fixture.debugElement.nativeElement.querySelector('#email');
//         const passwordElement: HTMLElement = fixture.debugElement.nativeElement.querySelector('#password');
//         const nameElement: HTMLElement = fixture.debugElement.nativeElement.querySelector('#name');
//         const phoneNumberElement: HTMLElement = fixture.debugElement.nativeElement.querySelector('#phone');
//         const addressElement: HTMLElement = fixture.debugElement.nativeElement.querySelector('#address');
//         const signUpButton: HTMLButtonElement = fixture.debugElement.nativeElement.querySelector('#signUpButton');

//         emailElement.dispatchEvent(new Event('focus'));
//         emailElement.dispatchEvent(new Event('blur'));

//         passwordElement.dispatchEvent(new Event('focus'));
//         passwordElement.dispatchEvent(new Event('blur'));

//         nameElement.dispatchEvent(new Event('focus'));
//         nameElement.dispatchEvent(new Event('blur'));

//         phoneNumberElement.dispatchEvent(new Event('focus'));
//         phoneNumberElement.dispatchEvent(new Event('blur'));

//         addressElement.dispatchEvent(new Event('focus'));
//         addressElement.dispatchEvent(new Event('blur'));

//         signUpButton.dispatchEvent(new Event('focus'));
//         signUpButton.dispatchEvent(new Event('blur'));


//         fixture.detectChanges();
//         fixture.whenStable().then(()=> {
//             const emailErrors: HTMLDivElement = fixture.debugElement.nativeElement.querySelector('#emailErrors');
//             const passwordErrors: HTMLDivElement = fixture.debugElement.nativeElement.querySelector('#passwordErrors');
//             const usernameErrors: HTMLDivElement = fixture.debugElement.nativeElement.querySelector('#usernameErrors');
//             const phoneNumberErrors: HTMLDivElement = fixture.debugElement.nativeElement.querySelector('#phoneNumberErrors');
//             const addressErrors: HTMLDivElement = fixture.debugElement.nativeElement.querySelector('#addressErrors');
//             //const signUpButton: HTMLButtonElement = fixture.debugElement.nativeElement.querySelector('#signUpButton');

//             fixture.detectChanges();

//             expect(emailErrors.children.length).toEqual(1);
//             expect(emailErrors.children[0].innerHTML).toEqual(' Email is required. ');
            
//             expect(passwordErrors.children.length).toEqual(1);
//             expect(passwordErrors.children[0].innerHTML).toEqual(' Password is required. ');

//             expect(usernameErrors.children.length).toEqual(1);
//             expect(usernameErrors.children[0].innerHTML).toEqual(' Name is required. ');

//             expect(phoneNumberErrors.children.length).toEqual(1);
//             expect(phoneNumberErrors.children[0].innerHTML).toEqual(' Phone is required. ');

//             expect(addressErrors.children.length).toEqual(1);
//             expect(addressErrors.children[0].innerHTML).toEqual(' Address is required. ');

//             expect(signUpButton.disabled).toBeTruthy();
//         });
//     }); 

//      it('email, username and password validation for patterns - invalid inputs, submit button disabled',() =>{
//         fixture.detectChanges();
//         fixture.whenStable().then(() => {
//           const emailElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#email');
//           const passwordElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#password');
//           const nameElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#name');
//           const phoneNumberElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#phone');
//           const addressElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#address');
//           const signUpButton: HTMLButtonElement = fixture.debugElement.nativeElement.querySelector('#signUpButton');


//           emailElement.value = 'abc';
//           passwordElement.value = '12';
//           nameElement.value = 'ab'
//           phoneNumberElement.value = '';
//           addressElement.value = '';


//           emailElement.dispatchEvent(new Event('input'));
//           passwordElement.dispatchEvent(new Event('input'));
//           nameElement.dispatchEvent(new Event('input'));
//           phoneNumberElement.dispatchEvent(new Event('input'));
//           addressElement.dispatchEvent(new Event('input'));
//           signUpButton.dispatchEvent(new Event('focus'));

//           fixture.detectChanges();
//           fixture.whenStable().then(() => {
//             const emailErrors: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#emailErrors');
//             const userNameErrors: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#usernameErrors');
//             const passwordErrors: HTMLDivElement = fixture.debugElement.nativeElement.querySelector('#passwordErrors');
//             const phoneNumberErrors: HTMLDivElement = fixture.debugElement.nativeElement.querySelector('#phoneNumberErrors');
//             const addressErrors: HTMLDivElement = fixture.debugElement.nativeElement.querySelector('#addressErrors');
            


//             expect(emailErrors.children.length).toEqual(1);
//             expect(emailErrors.children[0].innerHTML).toEqual(' Invalid Email. ');

//             expect(userNameErrors.children.length).toEqual(1);
//             expect(userNameErrors.children[0].innerHTML).toEqual(' Name must be at least 3 characters long. ');

//             expect(passwordErrors.children.length).toEqual(1);
//             expect(passwordErrors.children[0].innerHTML).toEqual(' Name must be at least 3 characters long. ');

//             expect(phoneNumberErrors.children.length).toEqual(1);
//             expect(phoneNumberErrors.children[0].innerHTML).toEqual(' Phone is required. ');

//             expect(addressErrors.children.length).toEqual(1);
//             expect(addressErrors.children[0].innerHTML).toEqual(' Address is required. ');

//             expect(signUpButton.disabled).toBeTruthy();

//           });
//       }); 
//     });

//     it('email, username and password validation for patterns - valid inputs, and submit button DISABLED',() =>{
//       fixture.detectChanges();
//       fixture.whenStable().then(() => {
      
//       const emailElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#email');
//       const passwordElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#password');
//       const nameElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#name');
//       const phoneNumberElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#phone');
//       const addressElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#address');
//       const signUpButton: HTMLButtonElement = fixture.debugElement.nativeElement.querySelector('#signUpButton');


//       emailElement.value = 'prakruthi@gmail.com';
//       passwordElement.value = '122abc';
//       nameElement.value = 'Prakruthi'
//       phoneNumberElement.value = '5780921145';
//       addressElement.value = '200, Burk lane';


//       emailElement.dispatchEvent(new Event('input'));
//       passwordElement.dispatchEvent(new Event('input'));
//       nameElement.dispatchEvent(new Event('input'));
//       phoneNumberElement.dispatchEvent(new Event('input'));
//       addressElement.dispatchEvent(new Event('input'));
//       signUpButton.dispatchEvent(new Event('focus'));

//       fixture.detectChanges();
//       fixture.whenStable().then(() => {

//         expect(signUpButton.disabled).toBeTruthy();

//       });
//     });  
//   });

//   it('email, username and password validation for patterns - valid inputs, and submit button ENABLED',() =>{
//     fixture.detectChanges();
//     fixture.whenStable().then(() => {
//       const emailElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#email');
//       const passwordElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#password');
//       const nameElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#name');
//       const phoneNumberElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#phone');
//       const addressElement: HTMLInputElement = fixture.debugElement.nativeElement.querySelector('#address');
//       const signUpButton: HTMLButtonElement = fixture.debugElement.nativeElement.querySelector('#signUpButton');


//       emailElement.value = 'prakruthi@gmail.com';
//       passwordElement.value = '122abc';
//       nameElement.value = 'Prakruthi'
//       phoneNumberElement.value = '5780921145';
//       addressElement.value = '200, Burk lane';


//       emailElement.dispatchEvent(new Event('input'));
//       passwordElement.dispatchEvent(new Event('input'));
//       nameElement.dispatchEvent(new Event('input'));
//       phoneNumberElement.dispatchEvent(new Event('input'));
//       addressElement.dispatchEvent(new Event('input'));
//       signUpButton.dispatchEvent(new Event('focus'));

//       fixture.detectChanges();
//       fixture.whenStable().then(() => {

//         expect(signUpButton.disabled).toBeFalsy();

//       });
//   });
// }); 

// /* it('should trigger a signUp click event', () => {
//   fixture.detectChanges();
//   fixture.whenStable().then(() => {
//     let comp = fixture.componentInstance;
//     spyOn(comp, 'onSubmit');

//     let el = fixture.debugElement.query(By.css('button')).nativeElement.click();
//     expect(comp.onSubmit).toHaveBeenCalled();

//     this.router.navigate(['/login'])
//   });
// }); */




// });