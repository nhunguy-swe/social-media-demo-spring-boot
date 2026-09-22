# Social Media Demo (Spring Boot)

<p>
  <img src="https://img.shields.io/badge/Java-17%2B-orange" alt="Java">
  <img src="https://img.shields.io/badge/Spring%20Boot-Backend-6DB33F?logo=spring-boot&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Build-Maven-blue" alt="Maven">
</p>

**Mạng xã hội đơn giản** — dự án demo xây dựng backend cho một ứng dụng mạng xã hội cơ bản, sử dụng **Spring Boot**, quản lý bằng **Maven** (thông qua Maven Wrapper).

---

## Giới thiệu (About)

Dự án là bản demo backend cho một mạng xã hội tối giản, thực hành xây dựng REST API / ứng dụng web với **Spring Boot** theo kiến trúc phổ biến (Controller – Service – Repository – Entity). Phù hợp cho mục đích học tập, luyện tập Spring Boot, Spring Data JPA và các nghiệp vụ cơ bản của một mạng xã hội (người dùng, bài đăng...).

> Ghi chú: README này được soạn dựa trên cấu trúc dự án (Spring Boot + Maven) và mô tả ngắn gốc "Mạng xã hội đơn giản". Bạn bổ sung thêm phần **Tính năng chi tiết** bên dưới cho khớp chính xác với các API/chức năng đã triển khai trong `src/`.

---

## Tính năng chính (dự kiến — chỉnh lại theo thực tế)

- Quản lý người dùng: đăng ký, đăng nhập
- Đăng bài, xem bảng tin (news feed)
- Tương tác: like, bình luận (nếu có)
- Cung cấp REST API cho phần frontend/client kết nối tới

---

## 🛠 Công nghệ sử dụng

| Thành phần | Công nghệ |
|---|---|
| Ngôn ngữ | Java 17+ |
| Framework | Spring Boot |
| Data Access | Spring Data JPA (nếu có dùng — kiểm tra `pom.xml`) |
| Build tool | Maven (Maven Wrapper `mvnw` / `mvnw.cmd`) |

---

## Cấu trúc dự án

```
social-media-demo-spring-boot/
├── .mvn/wrapper/       # Cấu hình Maven Wrapper
├── src/
│   └── main/
│       ├── java/        # Source code: Controller, Service, Repository, Entity...
│       └── resources/     # File cấu hình application.properties/yml
├── mvnw / mvnw.cmd          # Maven Wrapper script (Linux/macOS & Windows)
├── pom.xml                    # Cấu hình Maven, khai báo dependencies
├── .gitignore
└── README.md
```

---

## Bắt đầu (Getting Started)

### Yêu cầu

- JDK 17+
- (Nếu có dùng database) MySQL/PostgreSQL hoặc DB tương ứng cấu hình trong `application.properties`
- IDE: IntelliJ IDEA / VS Code / Eclipse

### Cài đặt

```bash
git clone https://github.com/nhunguy-swe/social-media-demo-spring-boot.git
cd social-media-demo-spring-boot
```

### Cấu hình

Kiểm tra và cập nhật file cấu hình tại `src/main/resources/application.properties` (hoặc `.yml`) — đặc biệt là thông tin kết nối cơ sở dữ liệu nếu dự án có sử dụng.

### Chạy ứng dụng

Dùng Maven Wrapper có sẵn, không cần cài Maven riêng:

```bash
# macOS/Linux
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

Mặc định Spring Boot sẽ chạy tại `http://localhost:8080` (trừ khi được cấu hình cổng khác).

---

## Tác giả

- GitHub: [@nhunguy-swe](https://github.com/nhunguy-swe)

---

## Giấy phép

Dự án này được thực hiện cho mục đích học tập/thực hành cá nhân. Bạn có thể tham khảo, sử dụng lại code cho mục đích học tập.
