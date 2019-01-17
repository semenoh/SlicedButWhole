import UIKit
import app

class ViewController: UIViewController {
    
    var presenter: Presenter? = nil

    override func viewDidLoad() {
        super.viewDidLoad()
        
        let db = Database()
        //todo
        presenter = Presenter(db: db)

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    @IBOutlet weak var input: UITextField!
    
    @IBAction func submit(_ sender: Any) {
        presenter?.onSubmitClick(value: input.text)
        input.text = ""
    }
    
}
