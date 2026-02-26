#include <bits/stdc++.h>

using namespace std;


class DocumentElement {
public:
    virtual ~DocumentElement() = default;
    virtual string render() const = 0;
};


class TextElement : public DocumentElement {
private:
    string text;

public:
    explicit TextElement(const string& text) : text(text) {}

    string render() const override {
        return text;
    }
};


class ImageElement : public DocumentElement {
private:
    string imagePath;

public:
    explicit ImageElement(const string& imagePath)
        : imagePath(imagePath) {}

    string render() const override {
        return "[Image: " + imagePath + "]";
    }
};


class NewLineElement : public DocumentElement {
public:
    string render() const override {
        return "\n";
    }
};

class TabSpaceElement : public DocumentElement {
public:
    string render() const override {
        return "\t";
    }
};


class Document {
private:
    vector<unique_ptr<DocumentElement>> elements;

public:
    void addElement(unique_ptr<DocumentElement> element) {
        elements.push_back(move(element));
    }

    string render() const {
        string result;
        for (const auto& element : elements) {
            result += element->render();
        }
        return result;
    }
};

class Persistence {
public:
    virtual ~Persistence() = default;
    virtual void save(const string& data) = 0;
};


class FileStorage : public Persistence {
public:
    void save(const string& data) override {
        ofstream outFile("document.txt");

        if (outFile) {
            outFile << data;
            cout << "Document saved to document.txt\n";
        } else {
            cout << "Error opening file.\n";
        }
    }
};


class DBStorage : public Persistence {
public:
    void save(const string& data) override {
        cout << "Saving document to database...\n";
        // DB logic here
    }
};

class DocumentEditor {
private:
    Document* document;
    Persistence* storage;
    string renderedCache;

    void invalidateCache() {
        renderedCache.clear();
    }

public:
    DocumentEditor(Document* doc, Persistence* store)
        : document(doc), storage(store) {}

    void addText(const string& text) {
        document->addElement(make_unique<TextElement>(text));
        invalidateCache();
    }

    void addImage(const string& path) {
        document->addElement(make_unique<ImageElement>(path));
        invalidateCache();
    }

    void addNewLine() {
        document->addElement(make_unique<NewLineElement>());
        invalidateCache();
    }

    void addTabSpace() {
        document->addElement(make_unique<TabSpaceElement>());
        invalidateCache();
    }

    string renderDocument() {
        if (renderedCache.empty()) {
            renderedCache = document->render();
        }
        return renderedCache;
    }

    void saveDocument() {
        storage->save(renderDocument());
    }
};



int main() {

    Document document;
    FileStorage fileStorage;

    DocumentEditor editor(&document, &fileStorage);

    editor.addText("Hello, world!");
    editor.addNewLine();

    editor.addText("This is a real-world document editor example.");
    editor.addNewLine();

    editor.addTabSpace();
    editor.addText("Indented text after a tab space.");
    editor.addNewLine();

    editor.addImage("picture.jpg");

    cout << editor.renderDocument() << endl;

    editor.saveDocument();

    return 0;
}