# UM-System




##  توضیحات کلی


### در این پروژه:
- اطلاعات کاربران به‌صورت `private` نگهداری می‌شود و فقط از طریق متدهای `getter` و `setter` قابل دسترسی هستند.
- یک کلاس انتزاعی به نام `AbstractUser` ایجاد شده تا ویژگی‌ها و رفتارهای مشترک بین همه کاربران را تعریف کند.
- دو کلاس `Admin` و `NormalUser` به صورت زیرکلاس‌هایی از `AbstractUser` پیاده‌سازی شده‌اند.
- یک کلاس مدیریتی به نام `UserManager` برای اضافه‌کردن، نگهداری و نمایش کاربران ساخته شده است.




##  ساختار پروژه و کلاس‌ها

```
src/
├── ir.ac.kntu/
│   ├──Main.java
│   ├── AbstractUser.java
│   ├── Admin.java
│   ├── NormalUser.java
│   └── UserManager.java

```

###  AbstractUser.java

کلاس انتزاعی پایه برای همه کاربران.

**فیلدها:**
- `String firstName`
- `String lastName`
- `String email`
- `String password`

**متدها:**
- `public AbstractUser(String firstName, String lastName, String email, String password)`
- Getter/Setter برای تمام فیلدها
- `public abstract void displayUserInfo();`

---

###  Admin.java

کلاس مخصوص کاربران مدیر، که از `AbstractUser` ارث‌بری می‌کند.

**متدها:**
- سازنده `Admin(...)` با پارامترهای مربوط به فیلدها
- پیاده‌سازی متد `displayUserInfo()`
- `public void viewAllUsers(List<AbstractUser> users)` - نمایش لیست تمام کاربران

---

###  NormalUser.java

کلاس مخصوص کاربران عادی، که از `AbstractUser` ارث‌بری می‌کند.

**متدها:**
- سازنده `NormalUser(...)`
- پیاده‌سازی `displayUserInfo()` فقط برای اطلاعات خودش

---

###  UserManager.java

کلاسی برای مدیریت کاربران (مثل بانک اطلاعاتی ساده).

**فیلدها:**
- `List<AbstractUser> users` - لیست کاربران

**متدها:**
- `public void addUser(AbstractUser user)`
- `public List<AbstractUser> getAllUsers()`
- `public AbstractUser findUserByEmail(String email)`


---

###  Main.java

کلاس اصلی برای اجرای برنامه.

**کارهایی که انجام می‌شود:**
- ایجاد نمونه‌هایی از `Admin` و `NormalUser`
- افزودن آن‌ها به `UserManager`
- تست نمایش اطلاعات توسط کاربران مختلف

---

---

##  نحوه اجرا

1. ابتدا همه فایل‌ها را کامپایل کنید:
   ```bash
   javac src/**/*.java
   ```

2. سپس کلاس `Main` را اجرا نمایید:
   ```bash
   java src/Main
   ```

---

##  قابلیت‌ها

- تعریف چندین کاربر از نوع مدیر یا کاربر عادی
- نمایش اختصاصی اطلاعات توسط هر کاربر
- محافظت از داده‌ها با سطوح دسترسی
- امکان گسترش پروژه با نقش‌های جدید

