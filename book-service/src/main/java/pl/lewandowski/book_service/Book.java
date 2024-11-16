package pl.lewandowski.book_service;

public record Book(
        String info,
        String price,
        String author,
        String imageUrl,
        String purchaseUrl) {
}
