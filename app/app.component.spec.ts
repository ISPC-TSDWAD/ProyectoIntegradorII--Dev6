import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent], // Correcto para componentes standalone
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges(); // Esto es vital para que Angular procese los cambios
    const compiled = fixture.nativeElement as HTMLElement;
    
    // Verificamos que el h1 contenga el texto esperado
    // Asegurate de que en tu app.component.html realmente diga "Hello, Frontend"
    expect(compiled.querySelector('h1')?.textContent).toContain('Hello, Frontend');
  });
});