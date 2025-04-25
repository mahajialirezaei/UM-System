# UM-System

##  توضیحات کلی

در این پروژه، هدف ساخت یک سیستم ساده برای **مدیریت کاربران (User Management)** است.

سیستم شامل دو کلاس اصلی است:

- **User**: نماینده‌ای برای هر کاربر با اطلاعات پایه مانند نام و ایمیل.
- **UserManager**: کلاسی برای مدیریت مجموعه کاربران، شامل اضافه‌کردن و جستجو در میان کاربران.

---

##  User.java

کلاسی برای تعریف اطلاعات هر کاربر.

### فیلدها:
- `String firstName`
- `String lastName`
- `String email`
- `String password`
- `boolean isActive` → وضعیت فعال/غیرفعال بودن کاربر
- `String lastLogin` → آخرین زمان ورود (به صورت رشته‌ای)

###  متدها:
- سازنده:  
  `User(String firstName, String lastName, String email, String password)`

- Getter و Setter برای تمام فیلدها

- `public void displayUserInfo()`  
  نمایش اطلاعات کاربر

- `public void deactivateAccount()`  
  غیرفعال کردن حساب کاربر

- `public void activateAccount()`  
  فعال کردن حساب کاربر

- `public void updateLastLogin(String datetime)`  
  به‌روزرسانی زمان آخرین ورود

- `public boolean checkPassword(String inputPassword)`  
  بررسی صحت رمز عبور وارد شده

---

##  UserManager.java

کلاسی برای مدیریت کاربران مانند یک بانک اطلاعاتی کوچک.

###  فیلدها:
- `List<User> users` → لیستی از کاربران موجود

###  متدها:
- `public void addUser(User user)`  
  افزودن کاربر جدید

- `public List<User> getAllUsers()`  
  گرفتن لیست همه کاربران

- `public User findUserByEmail(String email)`  
  جستجوی کاربر از طریق ایمیل

---




---

