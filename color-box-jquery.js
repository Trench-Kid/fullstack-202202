var color = "grey"

$('#myForm').on('submit', function (e) {
    e.preventDefault();
    var $data = $(this).serializeArray()
    if($data[0].value <= 0 || $data[1].value <= 0)
    alert("Column and row must be bigger than zero.")
    else {
    createBox($data[0].value, $data[1].value, color)
    $('#data').text("Row count: " + $data[0].value + " Column count: " + $data[1].value)
    }
})

$('#blueOption').on('click', function (e) {
    color = "blue";
})
$('#redOption').on('click', function (e) {
    color = "red";
})
$('#purpleOption').on('click', function (e) {
    color = "purple";
})
$('#noneOption').on('click', function (e) {
    color = "grey";
})

function createBox(row, column, color) {
    var table = $('#myTable');
    table.empty()
    var i = 1;

    for (r = 0; r < row; r++) {
        var tableRow = $('<tr></tr>');
        for (c = 0; c < column; c++) {
            var rowData = $('<td></td>').addClass(`box ${color}`)
            rowData.attr('id', i++)
            rowData.attr('onClick', `changeColorOnClick(${rowData.attr('id')})`);
            tableRow.append(rowData)
        }
        table.append(tableRow)
    }
}
function changeColorOnClick(elementId) {
    var clickedBox = $(`#${elementId}`)
    clickedBox.removeAttr('class')
    clickedBox.addClass(`box ${color}`)

}
$('#clearBtn').on('click', function () {
    var allBox = $('.box')
    allBox.removeAttr('class')
    allBox.addClass('box grey')
})

$('#allFillBtn').on('click', function() {
    var allBox = $('.box')
    allBox.removeAttr('class')
    allBox.addClass(`box ${color}`)
})





