# Debugging Report

## 1. Bug Description
An intentional bug was introduced in the expense update feature. The program was incorrectly using the wrong input method while reading the new amount, which caused the update process to fail for valid numeric input.

## 2. Expected Result
When the user chooses to update an expense and enters a valid expense ID and amount, the amount should be updated successfully and the program should display:

```text
Expense Updated Successfully!
```

## 3. Actual Result
The program sometimes failed to read the amount correctly and displayed an error or treated the input as invalid.

## 4. Root Cause
The bug was caused by the use of the wrong scanner input method in the update flow, which led to incorrect reading of the numeric input.

## 5. Debugging Steps
1. Ran the project in the terminal.
2. Selected option 3 to update an expense.
3. Entered a valid expense ID and amount.
4. Observed that the input was not processed correctly.
5. Reviewed the update logic in the main class and traced the input handling flow.
6. Identified the faulty input-reading step.
7. Fixed the code to use the correct input method.

## 6. Screenshots
Screenshots should be added here after running the program locally.

Example:
- Screenshot 1: Console showing the bug while updating an expense.
- Screenshot 2: Console showing the fixed behavior after debugging.

## 7. Final Fix
The update logic was corrected so that the new amount is read properly and saved to the selected expense.
