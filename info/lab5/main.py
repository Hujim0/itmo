import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv("Data.csv", sep=",")

data = data.drop(["<TICKER>", "<PER>", "<VOL>", "<TIME>"], axis=1)

data_september = data[(data["<DATE>"] == "17/09/18")]
print(data_september)
data_october = data[(data["<DATE>"] == "17.10.2018")]
data_november = data[(data["<DATE>"] == "19.11.2018")]
data_december = data[(data["<DATE>"] == "17.12.2018")]

data_september[["<OPEN>", "<HIGH>", "<LOW>", "<CLOSE>"]].round().plot(kind='box', title='September')
plt.show()

data_october[["<OPEN>", "<HIGH>", "<LOW>", "<CLOSE>"]].round().plot(kind='box', title='October')
plt.show()

data_november[["<OPEN>", "<HIGH>", "<LOW>", "<CLOSE>"]].round().plot(kind='box', title='November')

data_december[["<OPEN>", "<HIGH>", "<LOW>", "<CLOSE>"]].round().plot(kind='box', title='December')

#create figure
