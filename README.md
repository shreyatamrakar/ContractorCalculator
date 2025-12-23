# Contractor Calculator

**Contractor Calculator** is a **simple Android app** built with **Jetpack Compose** that allows contractors or users to quickly calculate **labor + materials + tax** to get the total project cost.  
It demonstrates **modern Android development practices** including Compose UI, state management, and declarative layouts.

---

## Table of Contents

- [Features](#features)
- [Screenshots](#screenshots)
- [Installation](#installation)
- [Usage](#usage)
- [Dependencies](#dependencies)

---

## Features

- Enter **Labor** and **Materials** costs.  
- Automatically calculates **SubTotal, Tax (5%)**, and **Total**.  
- Simple, clean **Material 3 UI** using Jetpack Compose.  
- Works on devices with **Android 7.0 (API 24)** and above.  

---

## Screenshots

<p float="left">
  <img src="./screenshots/main_screen.png" alt="Main Screen" width="300" style="margin-right: 10px"/>
  <img src="./screenshots/calculation_screen.png" alt="Tip Calculation Screen" width="300"/>
</p>

*Screen showing input fields for Labor and Materials and the calculation result.*

---

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/ContractorCalculator.git
```
2. Open the project in **Android Studio**.  
3. Make sure your Android SDK is set to **API 34** or higher.  
4. Build and run the app on an emulator or device running **Android 7.0 (API 24)** or higher.

---

## Usage

1. Launch the app.  
2. Enter **Labor** and **Materials** amounts in the input fields.  
3. Tap **Calculate**.  
4. The app displays:
   - **SubTotal**  
   - **Tax (5%)**  
   - **Total**  

---

## Dependencies

Key dependencies:

- **Jetpack Compose** (Material 3, UI, UI Tooling)  
- **Compose activity integration** (`activity-compose`)  
- **AndroidX Core KTX, AppCompat, ConstraintLayout**  
- **JUnit & Espresso** for testing  

Full versions are defined in `build.gradle`.

---
