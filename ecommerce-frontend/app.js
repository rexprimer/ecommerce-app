document.addEventListener('DOMContentLoaded', () => {
    fetchProducts();
    fetchCustomers();
    fetchOrders();
});

function fetchProducts() {
    fetch('http://localhost:8082/products') // Adjust the URL as necessary
        .then(response => response.json())
        .then(data => {
            const productList = document.getElementById('product-list');
            productList.innerHTML = '<ul>' +
                data.map(product => `<li>${product.description} - $${product.price} (Stock: ${product.stock})</li>`).join('') +
                '</ul>';
        })
        .catch(error => console.error('Error fetching products:', error));
}

function fetchCustomers() {
    fetch('http://localhost:8081/customers') // Adjust the URL as necessary
        .then(response => response.json())
        .then(data => {
            const customerList = document.getElementById('customer-list');
            customerList.innerHTML = '<ul>' +
                data.map(customer => `<li>${customer.name} - ${customer.email}</li>`).join('') +
                '</ul>';
        })
        .catch(error => console.error('Error fetching customers:', error));
}

function fetchOrders() {
    fetch('http://localhost:8083/orders') // Adjust the URL as necessary
        .then(response => response.json())
        .then(data => {
            const orderList = document.getElementById('order-list');
            orderList.innerHTML = '<ul>' +
                data.map(order => `<li>Order ID: ${order.order_id}, Customer: ${order.customer.name}, Products: ${order.products.map(p => p.description).join(', ')}</li>`).join('') +
                '</ul>';
        })
        .catch(error => console.error('Error fetching orders:', error));
}
