package com.example.testlogic.api;

/**
 * Lớp Resource là một lớp generic dùng để biểu diễn trạng thái của một hoạt động bất đồng bộ.
 * Nó có thể ở trạng thái loading (đang tải), success (thành công), hoặc error (lỗi).
 *
 * @param <T> Kiểu dữ liệu của data.
 */
public class Resource<T> {

    public enum Status {
        LOADING, SUCCESS, ERROR
    }

    private final Status status;
    private final T data;
    private final String message;

    /**
     * Khởi tạo một Resource object với trạng thái, dữ liệu và message.
     *
     * @param status Trạng thái của hoạt động.
     * @param data Dữ liệu trả về nếu hoạt động thành công (có thể là null).
     * @param message Thông báo lỗi nếu hoạt động thất bại (có thể là null).
     */
    private Resource(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    /**
     * Tạo một Resource object với trạng thái thành công (SUCCESS) và data.
     *
     * @param data Dữ liệu trả về.
     * @param <T> Kiểu dữ liệu của data.
     * @return Resource object với trạng thái thành công.
     */
    public static <T> Resource<T> success(T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    /**
     * Tạo một Resource object với trạng thái lỗi (ERROR) và message.
     *
     * @param message Thông báo lỗi.
     * @param <T> Kiểu dữ liệu của data (luôn là null).
     * @return Resource object với trạng thái lỗi.
     */
    public static <T> Resource<T> error(String message) {
        return new Resource<>(Status.ERROR, null, message);
    }

    /**
     * Tạo một Resource object với trạng thái đang tải (LOADING).
     *
     * @param <T> Kiểu dữ liệu của data (luôn là null).
     * @return Resource object với trạng thái đang tải.
     */
    public static <T> Resource<T> loading() {
        return new Resource<>(Status.LOADING, null, null);
    }

    public Status getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}

