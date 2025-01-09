/*a. Returns the names of all Salesperson that don’t have any order with Samsonic.*/
SELECT DISTINCT s.Name
FROM Salesperson s
WHERE s.ID NOT IN (
    SELECT o.salesperson_id
    FROM Orders o
    JOIN Customer c ON o.customer_id = c.ID
    WHERE c.Name = 'Samsonic'
);

/*
b. Updates the names of Salesperson that have 2 or more orders. It’s necessary to add an
‘*’ in the end of the name.
*/

UPDATE Salesperson
SET Name = CONCAT(Name, '*')
WHERE ID IN (
    SELECT salesperson_id
    FROM Orders
    GROUP BY salesperson_id
    HAVING COUNT(ID) >= 2
);

/*c. Deletes all Ssalesperson that placed orders to the city of Jackson.*/
DELETE FROM Salesperson
WHERE ID IN (
    SELECT DISTINCT o.salesperson_id
    FROM Orders o
    JOIN Customer c ON o.customer_id = c.ID
    WHERE c.City = 'Jackson'
);

/*d. Total sales amount for each Salesperson (show 0 for no sales):*/
SELECT s.Name, COALESCE(SUM(o.Amount), 0) AS TotalSales
FROM Salesperson s
LEFT JOIN Orders o ON s.ID = o.salesperson_id
GROUP BY s.ID, s.Name;
