import gi
from gi.overrides.GdkPixbuf import GdkPixbuf

gi.require_version("Gtk", "3.0")
from gi.repository import Gtk
from widow_detail import WindowDetail


class Cell(Gtk.EventBox):
    name = None

    def __init__(self, name, image, descripcion):
        super().__init__()
        self.descripcion = descripcion
        self.name = name
        self.image = image

        box = Gtk.Box(orientation=Gtk.Orientation.VERTICAL, spacing=4)
        box.pack_start(Gtk.Label(label=name), False, False, 0)
        box.pack_start(image, True, True, 0)
        self.add(box)
        self.connect("button-release-event", self.on_click)

    def on_click(self, widget, event):
        #rescalar la imagen para el window_datail
        imagenNueva = Gtk.Image()
        imagenNueva.set_from_pixbuf(self.image.get_pixbuf().scale_simple(500, 500, GdkPixbuf.InterpType.BILINEAR))

        w = WindowDetail(imagenNueva, self.descripcion, self.name)
        w.show_all()

