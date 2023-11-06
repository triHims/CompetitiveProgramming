import csv
import psycopg2

# Connect to the database
conn = psycopg2.connect(
    host='localhost', database='mydatabase', user='myuser', password='mypassword')
cur = conn.cursor()

# Open the CSV file
with open('data.csv', 'r') as f:
    # Create a CSV reader
    reader = csv.reader(f)
    # Iterate over the rows of the CSV
    for row in reader:
        # Insert the row into the table
        cur.execute(
            'INSERT INTO mytable (col1, col2, col3) VALUES (%s, %s, %s)', row)

# Commit the changes
conn.commit()

# Close the cursor and connection
cur.close()
conn.close()
