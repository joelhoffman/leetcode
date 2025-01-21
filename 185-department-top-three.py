import pandas as pd

def top_three_salaries(employee: pd.DataFrame, department: pd.DataFrame) -> pd.DataFrame:
    ranked=employee.copy()
    ranked['rank'] = employee.groupby(['departmentId'],as_index=False)['salary']\
        .rank(method="dense", ascending=False)
    return ranked[ranked['rank'] <= 3]\
        .merge(department.rename(columns={'name':'Department'}), left_on='departmentId',right_on='id')\
        .rename(columns={'name':'Employee'})\
        [['Department','Employee','salary']]

