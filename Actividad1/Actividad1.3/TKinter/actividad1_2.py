from tkinter import *
from tkinter import messagebox

window = Tk()
window.title("Actividad 1.2 - TKinter")

Label(window, text="Indique su preferencia: ").pack()
Checkbutton(window, text="Fumador").pack()

def click():
    messagebox.OK("OK", "Seleccionado " )

boton = Button(window, text="ENVIAR", command=click).pack()


window.mainloop()