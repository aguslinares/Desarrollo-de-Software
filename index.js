fetch('https://fakestoreapi.com/products')
    .then(function (res) { return res.json(); })
    .then(function (products) {
    // Prepare table HTML
    var tableHTML = '<thead><tr><th>ID</th><th>Title</th><th>Description</th><th>Price</th></tr></thead><tbody>';
    // Loop thru all products to generate rowa of the table
    products.forEach(function (p) {
        tableHTML += '<tr><td>${p.id}</td><td>${p.title}</td><td>${p.description}</td><td>${p.price}</td></tr>';
    });
    //Close table body 
    tableHTML += '</tbody>';
    //Grab table element to set inner HTML
    document.querySelector('#tableElement').innerHTML = tableHTML;
    //Hide spinner
    var spinnerElement = document.querySelector('#spinnerContainer');
    spinnerElement.style.display = 'none';
});
